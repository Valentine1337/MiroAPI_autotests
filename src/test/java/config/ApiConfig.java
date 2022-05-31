package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configs/credentials.properties"
})
public interface ApiConfig extends Config {
    @Key("token")
    String token();

    @Key("testBoardId")
    String testBoardId();
}
