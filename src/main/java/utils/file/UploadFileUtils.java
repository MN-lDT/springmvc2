package utils.file;

import java.io.*;
import java.util.UUID;

/***
 * 进行文件的保存处理
 */
public class UploadFileUtils {
    /***
     * 进行文件的保存操作
     * @param inputStream 上传的原始文件数据输入流
     * @param destFile 要保存的目标文件的路径
     * @return 保存成功返回 true
     */
    public static Boolean save (InputStream inputStream, File destFile) {
        Boolean flag = false;
        OutputStream output = null;
        if (!destFile.getParentFile().exists()) { // 如果父路径不存在
            destFile.getParentFile().mkdir(); // 创建父路径
        }
        try {
            output = new FileOutputStream(destFile);
            byte data[] = new byte[2048];  // 每块数据的保存的大小
            int temp = 0 ; // 保存每次的个数
            while ((temp = inputStream.read(data)) != -1 ) {
                output.write(data,0,temp);
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /***
     * 创建要保存的文件的名称
     * @param mine
     * @return
     */
    public static String createFileName (String mine) { // 需要创建一个文件名称
        String fileName = UUID.randomUUID() + "." + mine.split("/")[1];
        return fileName;
    }
}
