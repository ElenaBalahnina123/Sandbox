package com.elena_balakhnina.recycler.view

//
//@AndroidEntryPoint
//class CategoryFragment : Fragment(R.layout.category_fragment) {
//
//    private val viewModel by viewModels<CategoryFragmentViewModel>()
//
//    @Inject
//    lateinit var imageCache: ImageCache
//
//
//    private val adapter = ExampleRecyclerView<CategoryFragmentListItem, CategoryItemBinding>(
//        factory = CategoryItemBinding::inflate,
//        onItemClick = { onClickCategoryFragment() },
//        binding = {
//            it.nameCategory.text = name_category
//            it.imageAdd.setImageDrawable(image)
//        }
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        viewModel.categoryListFlow().onEach {
//            adapter.submitList(it)
//        }.launchIn(lifecycleScope)
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        viewModel.count()
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        CategoryFragmentBinding.bind(view).apply {
//            recyclerViewCategory.adapter = adapter
//            btnCategoryAdd.setOnClickListener {
//                findNavController().navigate(
//                    CategoryFragmentDirections.actionCategoryFragmentToCategoryCreationFragment()
//                )
//            }
//
//            searchToolbarInCategoryFragment.setOnMenuItemClickListener {
//                when (it.itemId) {
//                    R.id.search -> {
//                        findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToSearchMainFragment())
//                        true
//                    }
//                    else -> false
//                }
//            }
//        }
//    }
//
//    private fun onClickCategoryFragment() {
//        findNavController().navigate(
//            CategoryFragmentDirections.actionCategoryFragmentToRecipesListFragment(0)
//        )
//    }
//}
//
//@HiltViewModel
//class CategoryFragmentViewModel @Inject constructor(
//    private val repository: BookRecipesRepository,
//    private val cache: ImageCache,
//) : ViewModel() {
//
//    init {
//        count()
//    }
//
//    fun count() {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.countAndLog()
//        }
//    }
//
//    fun categoryListFlow() = repository.categoryFlow()
//        .map { categories ->
//            categories.map { category ->
//                CategoryFragmentListItem(
//                    idCategory = category.idCategory,
//                    image = cache.getDrawableFromCache(category.image),
//                    name_category = category.name_category
//                )
//            }
//        }
//}
//
//data class CategoryFragmentListItem(
//    val idCategory: Long,
//    val image: Drawable,
//    val name_category: String
//)

