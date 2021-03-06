package com.benoitquenaudon.tvfoot.red.app.domain.matches.state;

import com.benoitquenaudon.tvfoot.red.api.TvfootService;
import com.benoitquenaudon.tvfoot.red.app.data.entity.Match;
import com.benoitquenaudon.tvfoot.red.app.data.entity.search.Filter;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

public class MatchesService {
  private final TvfootService tvfootService;
  private static final int MATCH_PER_PAGE = 30;

  @Inject MatchesService(TvfootService tvfootService) {
    this.tvfootService = tvfootService;
  }

  Single<List<Match>> loadPage(int pageIndex) {
    return tvfootService.findFuture(
        Filter.builder().limit(MATCH_PER_PAGE).offset(MATCH_PER_PAGE * pageIndex).build());
  }
}
