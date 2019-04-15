package com.example.project2.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project2.R;
import com.example.project2.model.LichSuThay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import static com.example.project2.GeneralProperties.ngayThayBoLoc;

public class BoLocAdapter extends RecyclerView.Adapter<BoLocAdapter.BoLocViewHolder> {
    List<LichSuThay> listLichSuThay = new ArrayList<>();
    public BoLocAdapter(List<LichSuThay> listLichSuThay) {
        this.listLichSuThay = listLichSuThay;
    }

    @NonNull
    @Override
    public BoLocViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View intView = layoutInflater.inflate(R.layout.thong_tin_bo_loc, null);
        return new BoLocViewHolder(intView);
    }

    @Override
    public void onBindViewHolder(@NonNull BoLocViewHolder boLocViewHolder, int i) {
        boLocViewHolder.setData(listLichSuThay.get(i));
    }


    @Override
    public int getItemCount() {
        return listLichSuThay.size();
    }

    public class BoLocViewHolder extends RecyclerView.ViewHolder {
        TextView tvThuTuBoLoc, tvNgayThay, tvHanDung, tvHanThay;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        public BoLocViewHolder(@NonNull View itemView) {
            super(itemView);
            initView();

        }

        private void initView() {
            this.tvThuTuBoLoc = itemView.findViewById(R.id.tv_thu_tu_bo_loc);
            this.tvNgayThay = itemView.findViewById(R.id.tv_ngay_thay);
            this.tvHanDung = itemView.findViewById(R.id.tv_han_dung);
            this.tvHanThay = itemView.findViewById(R.id.tv_han_thay);
        }

        public void setData(LichSuThay lichSuThay) {
            tvThuTuBoLoc.setText("Bộ lọc số:" + lichSuThay.getThuTuBoLoc());
            tvNgayThay.setText("Ngày Thay Gần Nhất :" + lichSuThay.getNgayThayGanNhat());
            tvHanDung.setText("Thời Gian Sử Dụng(Tháng) :" + lichSuThay.getHanSuDung());
            tvHanThay.setText("Ngày Nên Thay Mới :" + setHanThay(lichSuThay.getNgayThayGanNhat(),lichSuThay.getHanSuDung()));
        }

        private String setHanThay(String start, String distance) {
            String s = "";
            Date data = new Date();
            try {
                data = sdf.parse(start);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar s1 = Calendar.getInstance();
            s1.setTime(data);
            s1.setTimeInMillis(s1.getTimeInMillis() + getNumberTime(distance));
            boolean add = true;
            for(int i =0;i<ngayThayBoLoc.size();i++){
                if(s1.getTimeInMillis() == ngayThayBoLoc.get(i))
                    add = false;
            }
            if(add ==true){
                ngayThayBoLoc.add(s1.getTimeInMillis());
            }

            return sdf.format(s1.getTime());

        }

        private long getNumberTime(String s) {
            int tmp = s.lastIndexOf(",");
            long a = Long.parseLong(s.substring(0, tmp)) * 30 * 24 * 60 * 60 * 1000;
            return a;
        }

    }

}
