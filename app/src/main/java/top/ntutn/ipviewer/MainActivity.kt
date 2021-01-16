package top.ntutn.ipviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.net.NetworkInterface

class MainActivity : AppCompatActivity() {
    private val adapter by lazy { IPAdapter(listOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initIPList()
    }

    private fun initView() {
        ipRecyclerView.layoutManager = LinearLayoutManager(this)
        ipRecyclerView.adapter = adapter
    }

    private fun initIPList() {
        val ipList = getIPList()
        adapter.ipList = ipList
    }

    private fun getIPList(): List<String> {
        val res = mutableListOf<String>()
        val nis = NetworkInterface.getNetworkInterfaces()
        while (nis.hasMoreElements()) {
            val ias = nis.nextElement().inetAddresses
            while (ias.hasMoreElements()) {
                val ia = ias.nextElement()
                res.add(ia.hostAddress)
            }
        }
        return res
    }
}