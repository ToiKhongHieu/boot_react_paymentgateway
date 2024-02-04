import { Button } from '@mui/base'
import { Grid, Link, Typography } from '@mui/material'
import React from 'react'

const Footer = () => {
    return (
        <div>
            <Grid className='bg-black text-white text-center mt-10'
                container
                sx={{ bgcolor: "black", color: "white", py: 3 }}
            >
                <Grid item xs={12} sm={6} md={3}>
                    <Typography className='pb-5' variant='h6'>Company</Typography>
                    <div>
                        <Button className='pb-5' variant='h6'>About</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6'>Blog</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6'>Press</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6'>Jobs</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6'>Partners</Button>
                    </div>
                </Grid>

                <Grid item xs={12} sm={6} md={3}>
                    <Typography className='pb-5' variant='h6'>Solutions</Typography>
                    <div>
                        <Button className='pb-5' variant='h6' >MARKETING</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6' >ANALYTICS</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6' >COMMERCE</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6' >INSIGHTS</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6' >SUPPORTS</Button>
                    </div>
                </Grid>

                <Grid item xs={12} sm={6} md={3}>
                    <Typography className='pb-5' variant='h6'>Documentation</Typography>
                    <div>
                        <Button className='pb-5' variant='h6' >GUIDES</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6' >API STATUS</Button>
                    </div>
                </Grid>

                <Grid item xs={12} sm={6} md={3}>
                    <Typography className='pb-5' variant='h6'>Legals</Typography>
                    <div>
                        <Button className='pb-5' variant='h6' >CLAIM</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6' >PRIVACY</Button>
                    </div>
                    <div>
                        <Button className='pb-5' variant='h6' >TERMS</Button>
                    </div>
                </Grid>
                <Grid className='pt-20' item xs={20}>
                    <Typography variant='body2' component='p' align='center'>
                        &copy;2023 My Company. All rights reserved
                    </Typography>
                    <Typography variant='body2' component='p' align='center'>
                        Made with love by Me
                    </Typography>
                    <Typography variant='body2' component='p' align='center'>
                        Icons made by{' '}
                        <Link href='https://www.facebook.com/theengg2304/' color='inherit' underline='always'>
                            Thi nguyễn
                        </Link>{' '}
                        from{' '}
                        <Link href='https://www.facebook.com/theengg2304/' color='inherit' underline='always'>
                            www.thinguyen.com
                        </Link>
                    </Typography>
                </Grid>
            </Grid>
        </div>
    )
}

export default Footer