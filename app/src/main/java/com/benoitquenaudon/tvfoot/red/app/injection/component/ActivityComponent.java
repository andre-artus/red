package com.benoitquenaudon.tvfoot.red.app.injection.component;

import dagger.Subcomponent;
import com.benoitquenaudon.tvfoot.red.app.domain.main.MainActivity;
import com.benoitquenaudon.tvfoot.red.app.domain.match.MatchActivity;
import com.benoitquenaudon.tvfoot.red.app.domain.matches.MatchesActivity;
import com.benoitquenaudon.tvfoot.red.app.injection.module.ActivityModule;
import com.benoitquenaudon.tvfoot.red.app.injection.module.BundleModule;
import com.benoitquenaudon.tvfoot.red.app.injection.scope.ActivityScope;

@ActivityScope @Subcomponent(modules = {
    ActivityModule.class, //
    BundleModule.class,
}) public interface ActivityComponent {
  void inject(MainActivity mainActivity);

  void inject(MatchesActivity matchesActivity);

  void inject(MatchActivity matchActivity);
}