package com.benoitquenaudon.tvfoot.red.app.domain.matches;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.benoitquenaudon.tvfoot.red.R;
import com.benoitquenaudon.tvfoot.red.app.domain.matches.displayable.BroadcasterRowDisplayable;
import com.benoitquenaudon.tvfoot.red.app.injection.scope.ActivityScope;
import com.benoitquenaudon.tvfoot.red.databinding.BroadcasterRowBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

@ActivityScope public class BroadcastersAdapter
    extends RecyclerView.Adapter<BroadcastersAdapter.BroadcasterViewHolder> {
  private List<BroadcasterRowDisplayable> broadcasters = new ArrayList<>();

  @Inject public BroadcastersAdapter() {
  }

  @Override public BroadcasterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

    BroadcasterRowBinding binding =
        DataBindingUtil.inflate(layoutInflater, R.layout.broadcaster_row, parent, false);
    return new BroadcasterViewHolder(binding);
  }

  @Override public void onBindViewHolder(BroadcasterViewHolder holder, int position) {
    holder.bind(broadcasters.get(position));
  }

  @Override public int getItemCount() {
    return broadcasters.size();
  }

  void add(BroadcasterRowDisplayable broadcaster) {
    broadcasters.add(broadcaster);
  }

  public void addAll(Collection<BroadcasterRowDisplayable> broadcasters) {
    this.broadcasters.addAll(broadcasters);
  }

  static class BroadcasterViewHolder extends RecyclerView.ViewHolder {
    private final BroadcasterRowBinding binding;

    BroadcasterViewHolder(BroadcasterRowBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    public void bind(BroadcasterRowDisplayable broadcaster) {
      binding.setBroadcasterLogoPath(broadcaster.logoPath());
      binding.executePendingBindings();
    }
  }
}
