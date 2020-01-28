package com.site.blog.my.core.util;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class MarkDownUtil {
    /**
     * 转换md格式为html
     *
     * @param markdownString
     * @return
     */
    public static String mdToHtml(String markdownString) {
        if (StringUtils.isEmpty(markdownString)) {
            return "";
        }
        java.util.List<Extension> extensions = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        Node document = parser.parse(markdownString);
        HtmlRenderer renderer = HtmlRenderer.builder().softbreak("<br/>").extensions(extensions).build();
        String content = renderer.render(document);
        return content;
    }

    public static void main(String[] args) {
        String ss=MarkDownUtil.mdToHtml("# zeppelin编译\n" +
                "# 1.获取源码：\n" +
                "git clone git@github.com:apache/zeppelin.git\n" +
                "#2.编译：\n" +
                "cd zeppelin\n" +
                "mvn clean install -DskipTests=true\n" +
                "#3.遇到的问题\n" +
                "下载lzo包失败，可以配置代理翻墙\n" +
                "npm 安装失败，也推荐使用代理\n" +
                "#4 启动\n"
                );
        System.out.println(ss);
    }
}
