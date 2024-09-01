package com.demo.practice.networktest

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.net.wifi.WifiInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.demo.practice.Constant.TAG
import com.demo.practice.R
import com.demo.practice.databinding.ActivityNetworkCheckBinding

class NetworkCheckActivity : AppCompatActivity() {

    private var _binding : ActivityNetworkCheckBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNetworkCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(TAG, "NetworkCheckActivity onCreate - calling isNetworkAvailable")
        binding.txtStatus.text = if(isNetworkAvailable()) "Network Available" else "Network not available"

    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "NetworkCheckActivity onResume - calling registerNetworkCallback")
        //register network callback and start monitoring when in the activity is in foreground.
        getConnectivityManager().registerNetworkCallback(networkRequest, networkCallback)
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "NetworkCheckActivity onPause - calling unregisterNetworkCallback")
        //unregister the network callback  and stop monitoring when activity not fully visible
        getConnectivityManager().unregisterNetworkCallback(networkCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "NetworkCheckActivity onDestroy")
        _binding = null
    }
    private val networkRequest = getNetworkRequest()

    @JvmName("getNetworkRequest1")
    private fun getNetworkRequest(): NetworkRequest {
        return NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)    //here!!
            .build()
    }

    private val networkCallback = getNetworkCallBack()

    private fun getNetworkCallBack(): ConnectivityManager.NetworkCallback {
        return object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {    //when Wifi is on
                super.onAvailable(network)
                Log.i(TAG, "getNetworkCallBack onAvailable")
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                Log.i(TAG, "getNetworkCallBack onCapabilitiesChanged")
                val wifiInfo = networkCapabilities.transportInfo as WifiInfo
            }
            override fun onLost(network: Network) {    //when Wifi 【turns off】
                super.onLost(network)
                Log.i(TAG, "getNetworkCallBack onLost")
            }

            override fun onUnavailable() {
                super.onUnavailable()
                Log.i(TAG, "getNetworkCallBack onUnavailable")
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                super.onLosing(network, maxMsToLive)
                Log.i(TAG, "getNetworkCallBack onLosing")
            }
        }
    }

    private fun getConnectivityManager() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private fun isNetworkAvailable() : Boolean {
        val manager = getConnectivityManager()
        val capabilities = manager.getNetworkCapabilities(manager.activeNetwork)
        Log.i(TAG, "Network Download Speed - ${capabilities?.linkDownstreamBandwidthKbps}")
        Log.i(TAG, "Network Upload Speed - ${capabilities?.linkUpstreamBandwidthKbps}")
        Log.i(TAG, "Network Signal Strength - ${capabilities?.signalStrength}")
        return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }
}