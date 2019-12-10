package com.zues.mvvmsampleapp.ui.home.quotes

import com.xwray.groupie.databinding.BindableItem
import com.zues.mvvmsampleapp.R
import com.zues.mvvmsampleapp.data.db.entities.Quote
import com.zues.mvvmsampleapp.databinding.ItemQuoteBinding

/* ---  Created by akhtarz on 12/6/2019. ---*/
class QuoteItem(private val quote: Quote) : BindableItem<ItemQuoteBinding>() {
    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}