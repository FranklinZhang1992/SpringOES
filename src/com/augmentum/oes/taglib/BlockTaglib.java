package com.augmentum.oes.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.augmentum.oes.common.BlockAbstract;
import com.augmentum.oes.util.SpringUtil;

public class BlockTaglib extends TagSupport {

    private static final long serialVersionUID = -731946160867203549L;

    private String name;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int doStartTag() throws JspTagException {
        return SKIP_BODY;
    }


    @Override
    public int doEndTag() throws JspTagException {
        JspWriter out = pageContext.getOut();
        BlockAbstract blockAbstract = (BlockAbstract)SpringUtil.getBean(name);
        String html = blockAbstract.displayBlock(pageContext);
        try {
            out.print(html);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

}
