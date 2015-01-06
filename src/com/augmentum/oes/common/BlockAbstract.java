package com.augmentum.oes.common;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.jsp.PageContext;

public abstract class BlockAbstract {
    public String template;

    public String displayBlock(PageContext pageContext) {
        execute(pageContext);
        Writer body = new StringWriter();


        try {
            if (template != null && !template.trim().equals("")) {
                pageContext.pushBody(body);
                pageContext.include(template);
                pageContext.popBody();

                return body.toString();
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                body.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }

    protected abstract void execute(PageContext pageContext) ;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

}
