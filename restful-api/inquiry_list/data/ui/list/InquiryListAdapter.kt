package com.min.inquiry_list.data.ui.list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.min.inquiry_list.R
import com.min.inquiry_list.data.model.Inquiry
import com.min.inquiry_list.data.ui.detail.InquiryDetailActivity


// class path가 필요.
class InquiryListAdapter(private val context: Context) : RecyclerView.Adapter<InquiryListAdapter.ViewHolder>() {
    private var inquiryList: List<Inquiry> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_inquiry, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val inquiry = inquiryList[position]
        holder.bind(inquiry)
    }

    // 아이템 카운트 가져온다.
    override fun getItemCount(): Int {
        return inquiryList.size
    }

    // 리스트 업데이트 해준다.
    fun updateInquiryList(newList: List<Inquiry>) {
        inquiryList = newList
        notifyDataSetChanged()
    }

    /// inner 중첩클래스
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val companyName: TextView = itemView.findViewById(R.id.company_name)

        fun bind(inquiry: Inquiry) {
            companyName.text = inquiry.companyName

            itemView.setOnClickListener {
                val intent = Intent(context, InquiryDetailActivity::class.java)
                intent.putExtra("idx", inquiry.idx)
                context.startActivity(intent)
            }
        }
    }
}