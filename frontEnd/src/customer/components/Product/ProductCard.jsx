import React from 'react'
import "./Product.css"
const ProductCard = (props) => {
    return (
        <div className='productCart w-[15rem] m-3 transition-all cursor-pointer'>
            <div className='h-[20rem]'>
                <img className='h-full w-full object-cover object-left-top' src={props.product.imageUrl} alt='' />
            </div>
            <div className='textPart bg-white p-3'>
                <div>
                    <p className='font-bold opacity-60'>{props.product.brand}</p>
                    <p>{props.product.title}</p>
                </div>
                <div className='flex item-center space-x-2'>
                    <p className='font-semibold'>{props.product.price}</p>
                    <p className='line-through opacity-50777777'>{props.product.discountedPrice}</p>
                    <p className='text-green-600 font-semibold'>{props.product.discountPersent}%</p>
                </div>
            </div>
        </div>
    )
}

export default ProductCard