package com.verve.maxads.demo.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.verve.maxads.demo.domain.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
}