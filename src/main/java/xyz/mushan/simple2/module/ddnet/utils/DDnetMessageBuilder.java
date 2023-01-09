package xyz.mushan.simple2.module.ddnet.utils;

import catcode.CatCodeUtil;
import xyz.mushan.simple2.utils.LogUtil;

/**
 * @author mushan
 * @date 2022/12/30
 * @apiNote
 */
public class DDnetMessageBuilder {
    public static String queryPoints(Long points){
        StringBuilder result = new StringBuilder();
        if (points == 0L) {
            result.append("\n❤️您还是个萌新呢！先把教程图通关一下吧。");
        } else if(points <= 500L) {
            result.append("\n🦄初入茅庐！在简单图披荆斩棘吧！");
        } else if(points <= 1000L){
            result.append("\n🔥简单图已经难不倒你了呢！试试中阶图吧。");
        } else if(points <= 2000L){
            result.append("\n😎不错嘛！已经可以在高阶区稳扎稳打了");
        } else if (points <= 5000L){
            result.append("\n🤩大佬！请带带我上高阶吧。求求啦！");
        }else{
            result.append("\n😱神仙也莫过于如此吧！疯狂图就靠你了！");
        }
        return result.toString();
    }
}
