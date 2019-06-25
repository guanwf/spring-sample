package com.github.spring.sqldemo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sqldemo")
public class Sqldemo {
    private long id;
    private String name;
    private int enabled;

/*


CREATE TABLE `sqldemo` (
  `id` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键id',
  `name` varchar(62) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '插件名称',
  `enabled` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否开启（0，未开启，1开启）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


insert into sqldemo(id,name,enabled)
values(1,'abc',1);
insert into sqldemo(id,name,enabled)
values(2,'efs',1);


 */
}
