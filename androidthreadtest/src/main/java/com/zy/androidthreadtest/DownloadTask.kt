import android.app.ProgressDialog
import android.os.AsyncTask
import java.lang.Exception

class DownloadTask:AsyncTask<Unit,Int,Boolean>(){

    override fun onPreExecute() {
    }

    override fun doInBackground(vararg params: Unit?) = try {
        while (true){
            val downloadPercent = doDownload(23)//虚构的下载方法
            publishProgress(downloadPercent)
            if (downloadPercent!! >= 100){
                break
            }
        }
        true
    }catch (e:Exception){
        false
    }

    override fun onProgressUpdate(vararg values: Int?) {
        //更新下载进度
    }

    /**
     * 虚拟下载方法
     */
    private fun doDownload(value:Int): Int? {
        return value
    }
}