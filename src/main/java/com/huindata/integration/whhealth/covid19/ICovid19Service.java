package com.huindata.integration.whhealth.covid19;

import com.huindata.integration.whhealth.covid19.vo.CYXXRequestBody;
import com.huindata.integration.whhealth.covid19.vo.JCJGQSRequestBody;
import com.huindata.integration.whhealth.covid19.vo.JCJGRequestBody;
import com.huindata.integration.whhealth.covid19.vo.Response;

public interface ICovid19Service {
    /**
     * 核酸采样信息应急实时上报接口
     * @param requestBody
     * @return
     */
    public Response importCYXXResult(CYXXRequestBody requestBody);

    /**
     * 核酸检测标本检测机构签收应急实时上报接口
     * @param requestBody
     * @return
     */
    public Response importJCJGQSResult(JCJGQSRequestBody requestBody);

    /**
     * 核酸检测结果应急实时上报接口
     * @param requestBody
     * @return
     */
    public Response importJCJGResult(JCJGRequestBody requestBody);


}
