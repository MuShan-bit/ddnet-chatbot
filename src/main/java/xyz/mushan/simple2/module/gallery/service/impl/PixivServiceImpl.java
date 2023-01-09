package xyz.mushan.simple2.module.gallery.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import xyz.mushan.simple2.module.gallery.entity.dto.GetPixivImageDTO;
import xyz.mushan.simple2.module.gallery.entity.po.PixivImageData;
import xyz.mushan.simple2.module.gallery.service.PixivService;
import xyz.mushan.simple2.utils.HttpUtil;

/**
 * @author mushan
 * @date 2022/12/31
 * @apiNote
 */
@Service
public class PixivServiceImpl implements PixivService {
    static final String GET_IMAGE_API = "https://api.lolicon.app/setu/v2";
    @Override
    public PixivImageData getImage() {
        String result = HttpUtil.get(GET_IMAGE_API);
        System.out.println(result);
        GetPixivImageDTO imageDTO = JSON.parseObject(result, GetPixivImageDTO.class);
        return imageDTO.getData().get(0);
    }
}
