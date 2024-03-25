import { Grid } from '@mui/material'
import React from 'react'
import AdjustIcon from '@mui/icons-material/Adjust'

const OrderCard = () => {
    return (
        <div className='p-5 shadow-md shadow-black hover:shadow-2xl border'>
            <Grid sx={{ justifyContent: 'space-between' }} container spacing={2} >
                <Grid item xs={6}>
                    <div className="flex cursor-pointer">
                        <img className='w-[5rem] h-[5rem] object-cover object-top' src="https://th.bing.com/th/id/OIP.Uy4KYPLNs4S3OpvOj-5FbQHaLG?rs=1&pid=ImgDetMain" alt="" />
                        <div className="ml-5 space-y-2">
                            <p className='mb-2'>Áo phông của Phương Ly</p>
                            <p className='opacity-50 text-xs font-semibold'>Size: M</p>
                            <p className='opacity-50 text-xs font-semibold'>Color: White</p>
                        </div>
                    </div>
                </Grid>
                <Grid item xs={2}>
                    <p>$1999</p>
                </Grid>
                <Grid item xs={4}>
                    {true && <div><p>
                        <AdjustIcon sx={{ width: "15px", height: "15px" }} className='text-green-600 mr-2 text-sm' />
                        <span>
                            Delivered On March 03
                        </span>
                    </p>
                        <p className='text-xs'>
                            Your Item Has Been Delivered
                        </p>
                    </div>
                    }
                    {false && <p>
                        <span>
                            Expected Delivery On Mar 03
                        </span>
                    </p>
                    }
                </Grid>
            </Grid>
        </div>
    )
}

export default OrderCard