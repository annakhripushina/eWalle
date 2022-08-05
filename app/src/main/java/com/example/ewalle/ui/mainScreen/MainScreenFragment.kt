package com.example.ewalle.ui.mainScreen


import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.view.*
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.ewalle.App
import com.example.ewalle.R
import com.example.ewalle.data.model.Service
import com.example.ewalle.databinding.MainScreenFragmentBinding
import com.example.ewalle.extensions.CustomTypefaceSpan
import com.example.ewalle.presentation.mainScreen.MainScreenViewModel
import javax.inject.Inject


class MainScreenFragment : Fragment() {
    @Inject
    lateinit var viewModel: MainScreenViewModel

    private lateinit var binding: MainScreenFragmentBinding
    private val friendsAdapter = FriendsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity().applicationContext as App).appComponent.inject(this)
        binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFriendsAdapter()
        binding.balance.text = editBalanceFont(viewModel.getBalance())
        createServiceTable(viewModel.getServices())
    }

    private fun initFriendsAdapter() {
        binding.rvFriends.apply {
            adapter = friendsAdapter
        }
        friendsAdapter.items = viewModel.getFriends()
    }

    private fun editBalanceFont(balance: String): Spannable {
        val spanBalance: Spannable = SpannableString(balance)
        val commaTypeface = Typeface.create(
            ResourcesCompat.getFont(requireContext(), R.font.b612_regular),
            Typeface.NORMAL
        )

        spanBalance.forEachIndexed { index, c ->
            if (c.toString() == ",") {
                spanBalance.setSpan(
                    CustomTypefaceSpan(commaTypeface),
                    index, index + 1,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
            }
        }
        return spanBalance
    }

    private fun createServiceTable(services: List<Service>) {
        for (i in 0 until ROWS_COUNT) {
            val tableRow = TableRow(requireContext())
            var indexElement = (i + 1) * COLUMNS_COUNT
            tableRow.layoutParams = TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT,
                1.0f
            )

            if (indexElement > services.size)
                indexElement = services.size

            for (j in i * COLUMNS_COUNT until indexElement) {
                val serviceStub = ViewStub(requireContext())
                serviceStub.layoutResource = R.layout.service_item
                tableRow.addView(serviceStub)
                val serviceCard = serviceStub.inflate()
                val params = TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    0.0f
                )
                params.gravity = Gravity.CENTER
                serviceCard.layoutParams = params
                serviceCard.findViewById<ImageView>(R.id.service_image)
                    .setImageResource(services[j].image)
                serviceCard.findViewById<TextView>(R.id.service_name).text =
                    services[j].name.replace(" ", "\n")
            }

            binding.tableServices.addView(tableRow, i)
        }
    }

    companion object {
        const val COLUMNS_COUNT = 4
        const val ROWS_COUNT = 2
    }
}

