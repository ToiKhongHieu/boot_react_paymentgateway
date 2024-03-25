import React from 'react'
import AdressCard from '../AdressCard/AdressCard'
import OrderTraker from './OrderTraker'
import { Box, Grid } from '@mui/material'
import { deepPurple } from '@mui/material/colors'
import StarBorderIcon from '@mui/icons-material/StarBorder';

const OrderDetails = () => {
    return (
        <div className='lg:px-20 px-5'>
            <div>
                <h1 className="font-bold text-lg py-7">Delivery Address</h1>
                <AdressCard />
            </div>
            <div className='py-20'>
                <OrderTraker activeStep={3} />
            </div>
            <Grid className='space-y-5' container>
                {[1, 1, 1, 1, 1, 1].map(item =>
                    <Grid item container className='shadow-xl rounded-md p-5 border' sx={{ alignItems: 'center', justifyContent: 'space-between' }}>
                        <Grid item xs={6}>
                            <div className='flex items-center space-x-4'>
                                <img className='w-[5rem] h-[5rem] object-cover object-top' src="https://toplist.vn/images/800px/phuong-ly-557753.jpg" alt="" />
                                <div className='space-y-2 ml-5'>
                                    <p className='font-semibold'>Áo nỉ của Phương Ly</p>
                                    <p className='space-x-5 opacity-50 text-xs font-semibold'><span>Color: Yellow</span> <span>Size: M</span> </p>
                                    <p>Seller: Thi Nguyen</p>
                                    <p>$1999</p>
                                </div>
                            </div>
                        </Grid>
                        <Grid item>
                            <Box sx={{ color: deepPurple[500] }}>
                                <StarBorderIcon sx={{ fontSize: "2rem" }} className='px-2' />
                                <span>Rate & Review Product</span>
                            </Box>
                        </Grid>
                    </Grid>
                )}
            </Grid>
        </div>
    )
}

export default OrderDetails