package com.example.others.gzip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CompressStrToGZip {


    public static void main(String[] args) throws IOException {
        File file = new File("./others/src/main/java/com/example/others/gzip/gzip_demo_compress.json");
        GZIPOutputStream o = new GZIPOutputStream(new FileOutputStream(file));
        o.write(getStr().getBytes(UTF_8));
        o.close();
        System.out.println(DecompressGZipFile.decompressGZipFileToStr(file));
    }

    private static String getStr(){
        return "{\"queId\":\"24bc1a6281284e759421453cbfabe86e\",\"subjectName\":\"物理\",\"subjectId\":\"4\",\"gradeGroupName\":\"高中\",\"gradeGroupId\":\"3\",\"logicQuesTypeName\":\"单选\",\"logicQuesTypeId\":\"1\",\"writtenQuesTypeName\":\"单选题\",\"writtenQuesTypeId\":\"13f97b02f7e4f2c9d35ec1af3c2d1004\",\"difficulty\":2,\"content\":\"<p>这是一个test图片题目<img alt=\\\"\\\" height=\\\"72\\\" size=\\\"334\\\" src=\\\"https://tiku-fz-cdn.jiaoyanyun.com/imgFile/22077893-1107-4d34-a7fc-c1645de7f544.jpg\\\" width=\\\"127\\\" /></p>\",\"answer\":[[\"B\"]],\"analysis\":[\"<p>d</p>\"],\"queSource\":\"其它\",\"answerOptionList\":[[{\"aoVal\":\"A\",\"content\":\"<p>a</p>\"}],[{\"aoVal\":\"B\",\"content\":\"<p>a</p>\"}],[{\"aoVal\":\"C\",\"content\":\"<p>c</p>\"}],[{\"aoVal\":\"D\",\"content\":\"<p>d</p>\"}]],\"examOptionList\":[{\"id\":\"91fd18c489ce4972afe7ce7f3e9ab399\",\"name\":\"电磁波及其应用\",\"lkcId\":\"9a10cfdab15048e1a2eaebf9a02d539b\",\"childList\":[{\"childList\":[],\"id\":\"8b30f12f20e14be084c588d1ad3c5fb3\",\"lkcId\":\"9a10cfdab15048e1a2eaebf9a02d539b\",\"name\":\"电磁波的波长、频率和波速的关系\"}]}],\"isCloze\":0,\"modifyDate\":\"2021-05-24 16:13:39\",\"score\":0.0,\"queDesc\":\"\",\"normalAnswer\":[[\"B\"]],\"blankAnswer\":null,\"blankInteraction\":[],\"isDecidable\":1,\"oneQuestionMoreAnalysisArr\":[\"<p>d</p>\"],\"answerType\":0,\"quePreviewURL\":\"\",\"createrId\":null,\"creater\":null,\"childList\":null,\"isIntoAnswerTool\":1,\"keyboardType\":0,\"contentType\":4,\"eleType\":null,\"isKeyQue\":null,\"isIntoClass\":null,\"isStuShow\":null,\"isPush\":null,\"eleId\":\"5f88612f398640759254bdef7fba7e9b\",\"parasiticQuestion\":null,\"paperId\":\"\",\"eleIndex\":null,\"eleNumber\":\"\",\"eleNumberContent\":\"\",\"videoId\":\"\",\"videoType\":null,\"videoList\":null,\"analysisVideoList\":null,\"sourceIndex\":null,\"teacherRemark\":\"\",\"isShowSource\":null,\"isShowDifficulty\":null,\"childScore\":\"\",\"blank\":null,\"isVideo\":0,\"isTingli\":0,\"normalBlank\":null,\"stuBlank\":null,\"pageBreak\":null,\"teaPageBreak\":null,\"stuPageBreak\":null,\"showQrcode\":0,\"analysisIndex\":\"\",\"childBlank\":\"\",\"processRecord\":null,\"materialConfig\":null,\"isPictureRecording\":null,\"courseWareId\":\"FE4E0ED86DC74E788E3EA2B03CC989D3\",\"courseWarePageId\":\"BA221F56F87C47528D66B027A4E48984\"}";
    }

}
