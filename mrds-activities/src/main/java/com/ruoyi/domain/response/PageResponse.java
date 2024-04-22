package com.ruoyi.domain.response;

import com.ruoyi.common.constant.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {
    /** 总记录数 */
    private long total;
    /** 列表数据 */
    private List<T> rows;
    /** 消息状态码 */
    private int code;
    /** 消息内容 */
    private String msg;

    public PageResponse(List<T> rows,long total){
        this.total=total;
        this.rows=rows;
        setCode(HttpStatus.SUCCESS);
        setMsg("分页成功");
    }
}
