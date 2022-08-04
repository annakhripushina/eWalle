package com.example.ewalle.ui


import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.view.*
import android.view.View.generateViewId
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginStart
import androidx.fragment.app.Fragment
import com.example.ewalle.App
import com.example.ewalle.R
import com.example.ewalle.databinding.MainScreenFragmentBinding
import com.example.ewalle.extensions.CustomTypefaceSpan
import com.example.ewalle.presentation.login.LoginViewModel
import com.example.ewalle.presentation.mainScreen.MainScreenViewModel
import javax.inject.Inject
import kotlin.math.ceil


class MainScreenFragment : Fragment() {
    private lateinit var binding: MainScreenFragmentBinding

    @Inject
    lateinit var viewModel: MainScreenViewModel

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
        val text = "21,600,000"
        val spanBalance: Spannable = SpannableString(text)
        val commaTypeface = Typeface.create(
            ResourcesCompat.getFont(requireContext(), R.font.b612_regular),
            Typeface.NORMAL
        )

        spanBalance.forEachIndexed { index, c ->
            if (c.toString() == ","){
                spanBalance.setSpan(
                    CustomTypefaceSpan(commaTypeface),
                    index, index + 1,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
            }
        }

        binding.balance.text = spanBalance

        val services = viewModel.getServices()

        val columns = 4
        val rows = 2//ceil(services.size/columns.toDouble()).toInt()

/*
        var stubList: ArrayList<ViewStub> = ArrayList()

        services.forEach{
            val stub = ViewStub(requireContext())
            stub.layoutResource = R.layout.service_item
            stubList.add(stub)
        }

        val constraintLayout: ConstraintLayout = ConstraintLayout(requireContext())

        val arrayId: Array<Int> = Array(5){0}
        //for (tv in stubList) {
        stubList.forEachIndexed { index, viewStub ->
            viewStub.id = generateViewId() // Views must have IDs in order to add them to chain later.
            //arrayId[]

            constraintLayout.addView(viewStub)
            val card = viewStub.inflate()

            card.findViewById<TextView>(R.id.service_name).text = "index $index$index"
            card.findViewById<ImageView>(R.id.service_image).setImageResource(R.drawable.ic_filter)
        }

        val constraintSet = ConstraintSet()
        constraintLayout.id = generateViewId()
        constraintSet.clone(constraintLayout)

        var previousItem: ViewStub? = null
        for (tv in stubList) {
            val lastItem = stubList.indexOf(tv) == stubList.size - 1
            if (previousItem == null) {
                constraintSet.connect(
                    tv.id,
                    ConstraintSet.START,
                    ConstraintSet.PARENT_ID,
                    ConstraintSet.START
                )
            } else {
                constraintSet.connect(
                    tv.id,
                    ConstraintSet.START,
                    previousItem.id,
                    ConstraintSet.END
                )
                if (lastItem) {
                    constraintSet.connect(
                        tv.id,
                        ConstraintSet.END,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.END
                    )
                }
            }
            previousItem = tv
        }

        stubList.forEachIndexed { index, viewStub ->
            arrayId[index] = viewStub.id
        }

        constraintSet.createHorizontalChain(
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.RIGHT,
            arrayId.toIntArray(),
            null,
            ConstraintSet.CHAIN_SPREAD_INSIDE
        )

        constraintSet.applyTo(constraintLayout)


       // val tableRow = TableRow(requireContext())
//            tableRow.layoutParams = TableLayout.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.MATCH_PARENT,
//                0.0f
//            )
       // tableRow.addView(constraintLayout)
        binding.tableServices.addView(constraintLayout)*/

        for (i in 0 until rows) {

            val tableRow = TableRow(requireContext())
            tableRow.layoutParams = TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT,
                1.0f
            )

            var indexElement = (i+1)*columns
            if (indexElement > services.size)
                indexElement = services.size

            for (j in i*columns until indexElement){
                val stub = ViewStub(requireContext())
                stub.layoutResource = R.layout.service_item

                tableRow.addView(stub)
                val card = stub.inflate()
                val params = TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    0.0f
                )
                params.gravity = Gravity.CENTER
                card.layoutParams = params
                card.findViewById<ImageView>(R.id.service_image).setImageResource(services[j].image)
                card.findViewById<TextView>(R.id.service_name).text = services[j].name.replace(" ", "\n")
            }

            binding.tableServices.addView(tableRow, i)
        }

    }
}

