package com.example.project2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import com.example.project2.R;

import com.example.project2.activities.HienThiBoLoc;
import com.example.project2.model.DonHang;
import com.example.project2.model.SanPham;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import static com.example.project2.GeneralProperties.sanPhamList;

public class ThietBiAdapter extends RecyclerView.Adapter<ThietBiAdapter.ThietBiViewHolder> {
    List<DonHang> donHangList = new ArrayList<>();
    Context context;
    public ThietBiAdapter(List<DonHang> donHangList,Context context) {
        this.donHangList = donHangList;
        this.context = context;
    }

    @NonNull
    @Override
    public ThietBiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View intView = layoutInflater.inflate(R.layout.mot_thiet_bi, null);
        return new ThietBiViewHolder(intView);
    }

    @Override
    public void onBindViewHolder(@NonNull ThietBiViewHolder thietBiViewHolder, int i) {
        thietBiViewHolder.setData(donHangList.get(i),context);
    }

    @Override
    public int getItemCount() {
        return donHangList.size();
    }

    public class ThietBiViewHolder extends RecyclerView.ViewHolder {
        TextView tvMaHD, tvTenSP, tvNgayMua, tvNgayBaoHanh;
        ImageView ivSP;
        Button btChiTiet;
        String tenThietBi;

        public ThietBiViewHolder(@NonNull View itemView) {
            super(itemView);
            initView();
        }

        public void initView() {
            tvMaHD = itemView.findViewById(R.id.tv_ma_giao_dich);
            tvTenSP = itemView.findViewById(R.id.tv_ten_sp);
            tvNgayBaoHanh = itemView.findViewById(R.id.tv_time_bh);
            tvNgayMua = itemView.findViewById(R.id.tv_time_mua);
            ivSP = itemView.findViewById(R.id.iv_thiet_bi);
            btChiTiet = itemView.findViewById(R.id.bt_chi_tiet);

        }

        public void setData(final DonHang donHang, final Context context) {
            tvMaHD.append(donHang.getMaHD());
            tvNgayMua.append(donHang.getNgayMua());
            tenThietBi = donHang.getThietBi();
            tvTenSP.append(tenThietBi);
            for (SanPham sp : sanPhamList) {
                if (sp.getNameSP().equals(tenThietBi)) {
                    Picasso.get().load(sp.getImageSP()).into(ivSP);
                }
            }
            btChiTiet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, HienThiBoLoc.class);
                    intent.putExtra("hang",tenThietBi);
                    intent.putExtra("maHD",donHang.getMaHD());
                    context.startActivity(intent);
                }
            });
        }

    }
}
