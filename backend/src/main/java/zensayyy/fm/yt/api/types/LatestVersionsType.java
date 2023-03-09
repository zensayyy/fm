package zensayyy.fm.yt.api.types;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
class BaseStreamType {
    public int itag;
    public String url;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class StreamingDataType {
    public BaseStreamType[] adaptiveFormats;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestVersionsType {
    public StreamingDataType streamingData; 


    public String findStreamByItag(int itag) {
        for(BaseStreamType stream: streamingData.adaptiveFormats) {
            if(stream.itag == itag) {
                return stream.url;
            }
        }
        return null;
    }
}
