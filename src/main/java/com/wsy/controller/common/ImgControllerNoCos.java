package com.wsy.controller.common;

import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.wsy.config.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@Controller
@RequestMapping("file")
public class ImgControllerNoCos {
    public static final String FILE_PATH = "D:\\immersive_shopping\\";
    static {
        File file = new File(FILE_PATH);
        file.mkdirs();
    }

    /**
     * 文件上传返回code为200
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    @ResponseBody
    public Result uplaod(@RequestParam("file") MultipartFile file)throws Exception {
        //用来检测程序运行时间
        String fileName =  IdWorker.get32UUID() +file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            File file1 = new File(FILE_PATH+"\\"+fileName);
            file1.createNewFile();
            //获取输出流
            OutputStream os=new FileOutputStream(file1.getPath());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();
            InputStream inputStream = new FileInputStream(file1.getPath());
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Result.error("上传文件失败");
        }
        return Result.success("/file/pic?pictureName="+fileName,"文件上传成功");
    }

    /**
     * 获取本地图片
     * @param pictureName //文件名
     * @return
     */
    @RequestMapping("/pic")
    public void ShowImg(String pictureName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //这里是存放图片的文件夹地址
        FileInputStream fileIs=null;
        OutputStream outStream = null;
        try {
            fileIs = new FileInputStream(FILE_PATH+"/"+pictureName);
            //得到文件大小
            int i=fileIs.available();
            //准备一个字节数组存放二进制图片
            byte data[]=new byte[i];
            //读字节数组的数据
            fileIs.read(data);
            //设置返回的文件类型
            response.setContentType("application/octet-stream;charset=UTF-8");
            //得到向客户端输出二进制数据的对象
            outStream=response.getOutputStream();
            //输出数据
            outStream.write(data);
            outStream.flush();
        } catch (Exception e) {
            return;
        }finally {
            if(outStream!=null){
                //关闭输出流
                outStream.close();
                //关闭输入流
                fileIs.close();
            }
        }
    }
}
