package org.mzero.mvc.render.impl;

import org.mzero.mvc.RequestProcessorChain;
import org.mzero.mvc.render.ResultRender;

import javax.servlet.http.HttpServletResponse;

/**
 * 内部异常渲染器
 *
 * @author Lei Chengdong
 * @date 2020/12/16
 */
public class InternalErrorResultRender implements ResultRender {
    private String errorMsg;

    public InternalErrorResultRender(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        requestProcessorChain.getResponse().sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,errorMsg);
    }
}
