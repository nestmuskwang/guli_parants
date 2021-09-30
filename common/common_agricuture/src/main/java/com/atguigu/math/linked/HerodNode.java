package com.atguigu.math.linked;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author wangshuguang
 * @Date 2021/9/30 15:02
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HerodNode {

    private  Integer  sort;

    private  String  name;

    private HerodNode next;

    public HerodNode(Integer sort, String name ){
        this.sort = sort;
        this.name = name;
    }
}
