package org.mzero.mvc.render.impl;

import com.google.gson.Gson;
import org.mzero.mvc.RequestProcessorChain;
import org.mzero.mvc.render.ResultRender;

import java.io.PrintWriter;

/**
 * Json渲染器
 *
 * @author chengdong.lei@hand-china.com 2020/08/16 17:21
 */
public class JsonResultRender implements ResultRender {
    private Object jsonData;
    public JsonResultRender(Object jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        // 设置响应头
        requestProcessorChain.getResponse().setContentType("application/json");
        requestProcessorChain.getResponse().setCharacterEncoding("UTF-8");
        // 响应流写入经过gson格式化后的处理结果
        try (PrintWriter writer = requestProcessorChain.getResponse().getWriter()) {
            Gson gson = new Gson();
            writer.write(gson.toJson(jsonData));
            writer.flush();
        }
    }
}