package com.shanxijuzhi.juzhi.tsak;

import com.shanxijuzhi.juzhi.model.TestDataInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;


@Configuration
@EnableScheduling//开启定时任务的支持
public class FileTask {

    @Resource
    private TestDataInfo testDataInfo;

    @Value("${file.url}")//获取文件的存储路径
    private String url;


    @Scheduled(cron="0/10 * * * * *")
    public List<TestDataInfo> scanFile() throws Exception {
        String saveUrl = url;
        System.out.println("存储文件的地址为"+ saveUrl);
        File file = new File(saveUrl);
        //遍历saveURl文件下的目录和文件
        File[] files = file.listFiles();

        for (File fs : files){
            //获取文件名
            String fileName = fs.getName();
            System.out.println(fileName);
            //获取文件的后缀名
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            //非目录(即文件是为excel文件.xls)则处理文件,数据插入到库中
            String path = url +"/"+fileName;
            System.out.println(fs);
            System.out.println(path);
            if (!fs.isDirectory() && suffix.equals("xls")) {
                ImportExcel<TestDataInfo> importExcel = new ImportExcel<TestDataInfo>();
                List<TestDataInfo> testDataInfos = importExcel.readxls(path,TestDataInfo.class);

                for (TestDataInfo tt:testDataInfos){


                    System.out.println("我删除了一些东西");
                    System.out.println(tt.getId());
                    System.out.println(tt.getNo());

                    System.out.println(tt);
                }
            }else if (!fs.isDirectory() && suffix.equals("xlsx")){
                ImportExcel<TestDataInfo> importExcel = new ImportExcel<TestDataInfo>();
                List<TestDataInfo> testDataInfos = importExcel.readxlsx(path,TestDataInfo.class);
                for (TestDataInfo tt:testDataInfos){
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000"+tt);

                }
            }

        }
        return null;

    }



}