package xyz.mushan.simple2.module.gallery.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.mushan.simple2.module.gallery.entity.po.PixivImageData;

import java.io.Serializable;
import java.util.List;

/**
 * @author mushan
 * @date 2022/12/31
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPixivImageDTO implements Serializable {
    @JSONField(name = "error")
    String error;
    @JSONField(name = "data")
    List<PixivImageData> data;
}
