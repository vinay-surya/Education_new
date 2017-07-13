package com.wexos.guru.education;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;

/**
 * Created by HP-8200 on 7/12/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.VideoViewHolder> {
    List<Youtube> youtubeList;

    public Adapter(List<Youtube> youtubeList) {
        this.youtubeList = youtubeList;
    }

    public Adapter() {
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video,parent,false);
        return new VideoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.webView.loadData(youtubeList.get(position).getUrl(),"text/html","utf-0");

    }

    @Override
    public int getItemCount() {
        return youtubeList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView webView;
        public VideoViewHolder(View itemView) {
            super(itemView);
            webView= (WebView) itemView.findViewById(R.id.you);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
        }
    }
}