package xyz.mushan.simple2.module.ddnet.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mushan
 * @date 2022/12/30
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DDnetUser implements Serializable {
    @JSONField(name = "name")
    String name;
    @JSONField(name = "points")
    Long points;
}
