package com.chrisjaunes.android_teaching.network.download;

/** Created by ChirsJaunes
 * 回调接口
 */
public interface DownloadListener {
    /**
     * 用于通知当前下载进度
     * @param progress
     */
    void onProgress(int progress);

    /**
     * 用于通知下载成功事件
     */
    void onSuccess();

    /**
     * 用于通知下载失败事件
     */
    void onFailed();

    /**
     * 用于通知下载成功事件
     */
    void onPaused();

    /**
     * 用于通知下载取消事件
     */
    void onCanceled();
}
