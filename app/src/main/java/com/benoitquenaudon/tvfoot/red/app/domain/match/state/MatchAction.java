package com.benoitquenaudon.tvfoot.red.app.domain.match.state;

import com.google.auto.value.AutoValue;

interface MatchAction {
  @AutoValue abstract class LoadMatchAction implements MatchAction {
    public abstract String matchId();

    public static LoadMatchAction create(String matchId) {
      return new AutoValue_MatchAction_LoadMatchAction(matchId);
    }
  }

  @AutoValue abstract class NotifyMatchStartAction implements MatchAction {
    public abstract String matchId();

    public abstract long startAt();

    public abstract boolean notifyMatchStart();

    public static NotifyMatchStartAction create(String matchId, long startAt,
        boolean notifyMatchStart) {
      return new AutoValue_MatchAction_NotifyMatchStartAction(matchId, startAt, notifyMatchStart);
    }
  }

  @AutoValue abstract class GetLastStateAction implements MatchAction {
    public static GetLastStateAction create() {
      return new AutoValue_MatchAction_GetLastStateAction();
    }
  }
}
