package xyz.mushan.simple2.module.gallery.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mushan
 * @date 2022/12/31
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixivImageDataUrl implements Serializable {
    @JSONField(name = "original")
    String original;
}