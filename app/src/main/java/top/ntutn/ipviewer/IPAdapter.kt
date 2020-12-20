package top.ntutn.ipviewer

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.ip_item.view.*

class IPAdapter(ipList: List<String>) : RecyclerView.Adapter<IPAdapter.IPViewHolder>() {
    var ipList= listOf<String>()
        set(value) {
            DiffUtil.calculateDiff(IPDiffCallback(field,value))
            field=value
        }

    init {
        this.ipList=ipList
    }

    class IPViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IPViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.ip_item, parent, false)
        return IPViewHolder(view)
    }

    override fun onBindViewHolder(holder: IPViewHolder, position: Int) {
//        holder.view.ipTextView.setBackgroundColor(if (position % 2 == 0) Color.LTGRAY else Color.WHITE)
        holder.view.ipTextView.text = ipList[position]
    }

    override fun getItemCount() = ipList.size
}

class IPDiffCallback(val oldIPList: List<String>, val newIPList: List<String>) : DiffUtil.Callback() {
    override fun getOldListSize() = oldIPList.size

    override fun getNewListSize() = newIPList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldIPList[oldItemPosition] == newIPList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldIPList[oldItemPosition] == newIPList[newItemPosition]
}