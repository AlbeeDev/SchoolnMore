import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
class Recipe {
    @JsonProperty("type")
    String type;
    @JsonProperty("category")
    String category;
    @JsonProperty("key")
    Map<String, Ingredient> key;
    @JsonProperty("pattern")
    String[] pattern;
    @JsonProperty("result")
    Result result;
    @JsonProperty("show_notification")
    boolean show_notification;

    public Recipe(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Map<String, Ingredient> getKey() {
        return key;
    }

    public void setKey(Map<String, Ingredient> key) {
        this.key = key;
    }

    public String[] getPattern() {
        return pattern;
    }

    public void setPattern(String[] pattern) {
        this.pattern = pattern;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public boolean isShow_notification() {
        return show_notification;
    }

    public void setShow_notification(boolean show_notification) {
        this.show_notification = show_notification;
    }
}

class Ingredient {
    @JsonProperty("item")
    String item;
    @JsonProperty("tag")
    String tag;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

class Result {
    @JsonProperty("count")
    int count;
    @JsonProperty("item")
    String item;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}