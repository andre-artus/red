package io.oldering.tvfoot.red.data.model;

import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue public abstract class Broadcaster {
  public static TypeAdapter<Broadcaster> typeAdapter(Gson gson) {
    return new AutoValue_Broadcaster.GsonTypeAdapter(gson);
  }

  public static Broadcaster create(String name, String code, @Nullable String url) {
    return new AutoValue_Broadcaster(name, code, url);
  }

  public abstract String getName();

  public abstract String getCode();

  @Nullable public abstract String getUrl();
}