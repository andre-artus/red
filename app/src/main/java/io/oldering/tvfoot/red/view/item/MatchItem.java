package io.oldering.tvfoot.red.view.item;

import com.genius.groupie.GroupAdapter;
import com.genius.groupie.Item;

import java.util.List;

import io.oldering.tvfoot.red.R;
import io.oldering.tvfoot.red.customview.EmptiableRecyclerView;
import io.oldering.tvfoot.red.databinding.MatchItemBinding;
import io.oldering.tvfoot.red.viewmodel.BroadcasterViewModel;
import io.oldering.tvfoot.red.viewmodel.MatchViewModel;

public class MatchItem extends Item<MatchItemBinding> {
    private MatchViewModel matchVM;

    public MatchItem(MatchViewModel matchVM) {
        this.matchVM = matchVM;
    }

    @Override
    public int getLayout() {
        return R.layout.match_item;
    }

    @Override
    public void bind(MatchItemBinding viewBinding, int position) {
        viewBinding.setMatch(matchVM);

        EmptiableRecyclerView recyclerView = viewBinding.matchBroadcasters;

        GroupAdapter broadcastersAdapter = new GroupAdapter(null);
        for (BroadcasterViewModel broadcasterViewModel : matchVM.getBroadcasters()) {
            broadcastersAdapter.add(new BroadcasterItem(broadcasterViewModel.getCode()));
        }
        // TODO(benoit) ugly stuff I would like to make better ( use the empty view of my recycler view )
        // seems to be high cost on the UI (lot of jank)
        if (broadcastersAdapter.getItemCount() == 0) {
            broadcastersAdapter.add(new BroadcasterItem("ic_tv_black_18px"));
        }
        recyclerView.setAdapter(broadcastersAdapter);
    }

    @Override
    public void bind(MatchItemBinding viewBinding, int position, List<Object> payloads) {
        super.bind(viewBinding, position, payloads);
    }
}