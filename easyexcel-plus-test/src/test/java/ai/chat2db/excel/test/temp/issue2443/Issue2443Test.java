package ai.chat2db.excel.test.temp.issue2443;

import java.io.File;
import java.text.ParseException;

import ai.chat2db.excel.EasyExcel;
import ai.chat2db.excel.metadata.property.ExcelContentProperty;
import ai.chat2db.excel.read.listener.PageReadListener;
import ai.chat2db.excel.util.NumberUtils;
import ai.chat2db.excel.test.util.TestFileUtil;
import com.alibaba.fastjson2.JSON;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@Slf4j
public class Issue2443Test {
    //CS304 (manually written) Issue link: https://github.com/alibaba/easyexcel/issues/2443
    @Test
    public void IssueTest1() {
        String fileName = TestFileUtil.getPath() + "temp/issue2443" + File.separator + "date1.xlsx";
        EasyExcel.read(fileName, Issue2443.class, new PageReadListener<Issue2443>(dataList -> {
            for (Issue2443 issueData : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(issueData));
            }
        })).sheet().doRead();
    }

    //CS304 (manually written) Issue link: https://github.com/alibaba/easyexcel/issues/2443
    @Test
    public void IssueTest2() {
        String fileName = TestFileUtil.getPath() + "temp/issue2443" + File.separator + "date2.xlsx";
        EasyExcel.read(fileName, Issue2443.class, new PageReadListener<Issue2443>(dataList -> {
            for (Issue2443 issueData : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(issueData));
            }
        })).sheet().doRead();
    }

    @Test
    public void parseIntegerTest1() throws ParseException {
        String string = "1.00";
        ExcelContentProperty contentProperty = null;
        int Int = NumberUtils.parseInteger(string, contentProperty);
        Assertions.assertEquals(1, Int);
    }

    @Test
    public void parseIntegerTest2() throws ParseException {
        String string = "2.00";
        ExcelContentProperty contentProperty = null;
        int Int = NumberUtils.parseInteger(string, contentProperty);
        Assertions.assertEquals(2, Int);
    }

}