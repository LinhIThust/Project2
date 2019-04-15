package com.example.project2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2.R;
import com.example.project2.model.SanPham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {
    List<SanPham> sanPhams = new ArrayList<>();

    public SanPhamAdapter(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    @NonNull
    //tạo itemview chi dung 1 lan khi recycle view khoi tao
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View intView = layoutInflater.inflate(R.layout.sam_pham, null);
        return new SanPhamViewHolder(intView);
    }

    @Override
    //load data len itemview
    public void onBindViewHolder(@NonNull SanPhamViewHolder sanPhamViewHolder, int i) {
        sanPhamViewHolder.setData(sanPhams.get(i));
    }

    @Override
    public int getItemCount() {
        return sanPhams.size();
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameSP, hangSP, giaSP;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.iv_sanpham);
            this.nameSP = itemView.findViewById(R.id.tv_name_sp);
            this.hangSP = itemView.findViewById(R.id.tv_hang_sp);
            this.giaSP = itemView.findViewById(R.id.tv_gia);
        }

        public void setData(SanPham sanPham) {
            Picasso.get().load(sanPham.getImageSP()).into(imageView);
            nameSP.setText(sanPham.getNameSP());
            giaSP.setText("Giá " + sanPham.getGiaSP() + "");
            hangSP.setText("Hàng Việt Nam Chất Lượng Cao!");
        }

    }
}
