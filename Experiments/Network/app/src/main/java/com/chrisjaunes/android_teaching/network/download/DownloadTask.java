package com.chrisjaunes.android_teaching.network.download;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/** Created by ChirsJaunes
 * 利用AsyncTask
 * 参考郭霖大佬的《第一行代码》第二版
 * 第一个参数是url，下载的地址
 * 第二个参数是用来显示进度
 * 第三个是用来反馈执行结果
 */
public class DownloadTask extends AsyncTask<String,Integer,Integer> {
    public static final int TYPE_SUCCESS=0;
    public static final int TYPE_FAILED=1;
    public static final int TYPE_PAUSED=2;
    public static final int TYPE_CANCELED=3;
    private DownloadListener listener;
    private boolean isCanceled=false;
    private boolean isPaused=false;
    private int lastProgress;
    public DownloadTask(DownloadListener listener){
        this.listener = listener;
    }

    /** Created by ChirsJaunes
     * 后台具体的下载逻辑
     * 从URL中获取文件名，获取下载目录路径，创建文件
     * downloadedLength 代表 记录已下载的文件长度
     * contentLength 获取 需要下载的文件长度
     * 比较 downloadedLength 和 contentLength 来检查文件是否下载完成
     * downloadURL 代表 获取传入的URL
     * 构造请求并发起下载
     * 在header里加入参数实现断点续传
     * @param params
     * @return
     */
    @Override
    protected Integer doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile savedFile = null;
        File file = null;
        try{
            String downloadURL = params[0];
            String fileName = downloadURL.substring(downloadURL.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory+fileName);

            long downloadedLength = 0;
            if(file.exists()) { downloadedLength = file.length(); }

            long contentLength = getContentLength(downloadURL);
            if(contentLength == 0) {
                return TYPE_FAILED;
            }else if(contentLength == downloadedLength) {
                return TYPE_SUCCESS;
            }

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE","bytes="+downloadedLength+"-")
                    .url(downloadURL)
                    .build();
            Response response = client.newCall(request).execute();

            assert response.body() != null;
            is = response.body().byteStream();
            savedFile = new RandomAccessFile(file,"rw");
            savedFile.seek(downloadedLength);

            byte[] b = new byte[1024];
            int total = 0, len;

            while((len = is.read(b)) != -1){
                if(isCanceled) {
                    return TYPE_CANCELED;
                }else if(isPaused) {
                    return TYPE_PAUSED;
                }else{
                    total += len;
                    savedFile.write(b,0,len);

                    int progress = (int)((total+downloadedLength)*100/contentLength);
                    publishProgress(progress);
                }
            }
            response.body().close();
            return TYPE_SUCCESS;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(is != null) is.close();
                if(savedFile != null) savedFile.close();
                if(isCanceled && file != null) file.delete();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return TYPE_FAILED;
    }

    /** Created by ChirsJaunes
     * 更新下载进度
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if(progress > lastProgress){
            listener.onProgress(progress);
            lastProgress = progress;
        }
    }

    /** Created by ChirsJaunes
     * 通知最终的下载结果
     * @param status
     */
    @Override
    protected void onPostExecute(Integer status) {
        switch(status) {
            case TYPE_SUCCESS:
                listener.onSuccess();
                break;

            case TYPE_FAILED:
                listener.onFailed();
                break;

            case TYPE_PAUSED:
                listener.onPaused();
                break;

            case TYPE_CANCELED:
                listener.onCanceled();
                break;

            default:
                break;
        }
    }

    public void pauseDownload() {
        isPaused = true;
    }

    public void cancelDownload() {
        isCanceled = true;
    }

    private long getContentLength(String downloadUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        Response response = client.newCall(request).execute();
        if(response.body() != null && response.isSuccessful()){
            long contentLength = response.body().contentLength();
            response.body().close();
            return contentLength;
        }
        return 0;
    }
}
