package com.benoitquenaudon.tvfoot.red.app.domain.match;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import com.benoitquenaudon.tvfoot.red.app.domain.match.state.MatchViewState;
import com.benoitquenaudon.tvfoot.red.app.domain.matches.BroadcastersAdapter;
import javax.inject.Inject;

import static com.benoitquenaudon.tvfoot.red.app.common.PreConditions.checkNotNull;

public class MatchViewModel {
  private final BroadcastersAdapter broadcastersAdapter;
  public ObservableBoolean isLoading = new ObservableBoolean();
  public ObservableBoolean hasError = new ObservableBoolean(false);
  public ObservableBoolean hasData = new ObservableBoolean(false);
  public ObservableBoolean shouldNotifyMatchStart = new ObservableBoolean(false);
  public ObservableField<MatchDisplayable> match = new ObservableField<>();
  public ObservableField<String> errorMessage = new ObservableField<>();

  @Inject MatchViewModel(BroadcastersAdapter broadcastersAdapter) {
    this.broadcastersAdapter = broadcastersAdapter;
  }

  @SuppressWarnings("ThrowableResultOfMethodCallIgnored") void updateFromState(
      MatchViewState state) {
    isLoading.set(state.loading());
    hasError.set(state.error() != null);
    hasData.set(state.match() != null);
    shouldNotifyMatchStart.set(state.shouldNotifyMatchStart());

    if (hasError.get()) {
      Throwable error = checkNotNull(state.error(), "state error is null");
      errorMessage.set(error.toString());
    }
    if (hasData.get() && //
        (match.get() == null || !match.get().equals(state.match()))) {
      match.set(state.match());
      broadcastersAdapter.addAll(match.get().broadcasters());
    }
  }
}
