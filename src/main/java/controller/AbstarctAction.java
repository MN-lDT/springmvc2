package controller;

import org.springframework.context.MessageSource;
import org.springframework.web.multipart.MultipartFile;
import utils.file.UploadFileUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


public  abstract class AbstarctAction {
    /***
     * 生成图片名称
     * @param photo
     * @return
     */
    public String createFileName (MultipartFile photo) {
        if (photo.isEmpty()) { // 没有文件上传
            return "nophoto.png"; // 默认没有文件
        } else {  // 需要自己生成一个文件
            return UploadFileUtils.createFileName(photo.getContentType());
        }
    }
    public abstract String  gitFileUploadDir ();

    /***
     * 进行文件的保存处理
     * @param photo
     */
    /*public void saveFile  (MultipartFile photo, HttpServletRequest request) { // 保存上传的图片名称
        String filePath = request.getServletContext.getRealPath();
    }*/

    @Resource
    private MessageSource messageSource;

    /***
     * 根据指定的key的信息进行资源文件的读取控制
     * @param msgkey 表示要读取资源文件的key的内容
     * @param args
     * @return 表示资源对应内容
     */
    public String getValue(String msgkey,Object...args) {
        return this.messageSource.getMessage(msgkey,args,Locale.getDefault());
    }
}
