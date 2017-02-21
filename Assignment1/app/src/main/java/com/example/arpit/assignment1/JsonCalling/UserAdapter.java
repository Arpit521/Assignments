package com.example.arpit.assignment1.JsonCalling;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import java.util.List;

import com.example.arpit.assignment1.R;

import static com.example.arpit.assignment1.JsonCalling.LoadMoreRecyclerViewMain.*;

/**
 * Created by arpit on 9/2/17.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem,totalItemCount;
    protected Context context;
    private RecyclerView mRecyclerView;
    private List<products> productses;
    static int count=0;


    public UserAdapter(Context context,  List <products> mUsers, RecyclerView mRecyclerView)
    {

        this.context = context;
        this.productses = mUsers;

        if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager)
       {
           count++;
            Log.d("arpit",""+count);
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                   if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (mOnLoadMoreListener != null) {
                             mOnLoadMoreListener.onLoadMore();

                        }
                        isLoading = true;

                    }
                }
            });
      }
    }
    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }
    @Override public int getItemViewType(int position) {
        return productses.get(position)== null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }
    @Override
   /* public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == VIEW_TYPE_ITEM)
        {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_item, parent, false);
            viewHolder = new RecyclerViewHolders(layoutView);
        }
        else if(viewType==VIEW_TYPE_LOADING)
        {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading_item, parent, false);
            viewHolder = new ProgressViewHolder(layoutView);
        }
        return viewHolder;
    }*/
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       RecyclerView.ViewHolder userViewHolder=null;

        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_item, parent, false);
           // userViewHolder=new RecyclerViewHolders(view);
           userViewHolder=new RecyclerViewHolders(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading_item, parent, false);
            userViewHolder=new ProgressViewHolder(view);

        }
        return userViewHolder;
    }
    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof RecyclerViewHolders)
        {


            products message = productses.get(position);
            RecyclerViewHolders userViewHolder = (RecyclerViewHolders) holder;
            userViewHolder.tvName.setText(message.getProductEntity().getIdentifier().getSkuName());
            userViewHolder.tvEmailid.setText(message.getProductEntity().getIdentifier().getSkuId());
          //  userViewHolder.tvImage.setImageURI(Uri.parse(message.getProductEntity().getBasicInfo().getImageThumbnail()));
        }
        else if (holder instanceof ProgressViewHolder)
        {
            ProgressViewHolder loadingViewHolder = (ProgressViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override public int getItemCount()
    {
        return productses == null ? 0 : productses.size();
    }

    public void setLoaded()
    {
        isLoading = false;
    }

    public void appendList(List<products> mUsers)
    {
        /*count++;
        Log.d("arpit",""+count);*/
        //Log.e("ashar",""+mUsers);
        productses.addAll(mUsers);
    }
}
