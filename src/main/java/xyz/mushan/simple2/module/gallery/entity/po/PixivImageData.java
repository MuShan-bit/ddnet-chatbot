package xyz.mushan.simple2.module.gallery.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class PixivImageData implements Serializable {
    @JSONField(name = "pid")
    Long pid;
    @JSONField(name = "p")
    Integer p;
    @JSONField(name = "uid")
    Long uid;
    @JSONField(name = "title")
    String title;
    @JSONField(name = "author")
    String author;
    @JSONField(name = "r18")
    Boolean r18;
    @JSONField(name = "width")
    Integer width;
    @JSONField(name = "height")
    Integer height;
    @JSONField(name = "tags")
    List<String> tags;
    @JSONField(name = "ext")
    String ext;
    @JSONField(name = "aiType")
    Integer aiType;
    @JSONField(name = "uploadData")
    Long uploadData;
    @JSONField(name = "urls")
    PixivImageDataUrl urls;
}
