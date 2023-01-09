package xyz.mushan.simple2.manage;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author mushan
 * @date 2022/12/30
 * @apiNote
 */
public class DDnetWorkMange {
    public static void updateQueryPoints(Boolean flag) throws IOException {
        String src = DDnetWorkMange.class.getClassLoader().getResource("application.yml").getPath();
        Yaml yaml = new Yaml();
        FileWriter fileWriter;
        FileInputStream fileInputStream = new FileInputStream(new File(src));
        Map<String, Object> yamlMap = yaml.load(fileInputStream);
        Map<String, Object> map1 = (Map<String, Object>) yamlMap.get("robot");
        Map<String, Object> map2 = (Map<String, Object>) map1.get("ddnet");
        Map<String, Object> map3 = (Map<String, Object>) map2.get("work");
        map3.put("points", flag);
        fileWriter = new FileWriter(new File(src));
        fileWriter.write(yaml.dumpAsMap(yamlMap));
        fileWriter.flush();
        fileWriter.close();
        fileInputStream.close();
    }
}
